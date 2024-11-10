const express = require('express');
const app = express();
const port = 3000;
const { Eureka } = require('eureka-js-client'); // Importer Eureka client

const mongoose = require('mongoose'); // Importer Mongoose

// Middleware pour parser le JSON
app.use(express.json());

// Connexion à MongoDB
mongoose.connect('mongodb://mongodb:27017/AgriShare', {
    useNewUrlParser: true,
    useUnifiedTopology: true
})
    .then(() => console.log('Connecté à MongoDB'))
    .catch(err => console.error('Erreur de connexion à MongoDB:', err));

// Route pour ajouter un utilisateur
app.post('/user/api/add', async (req, res) => {
    const { name, email, password } = req.body;
    const user = new User({ name, email, password });

    try {
        await user.save();
        res.json({ message: 'Utilisateur ajouté avec succès', user });
    } catch (error) {
        res.status(500).json({ message: 'Erreur lors de l’ajout de l’utilisateur', error });
    }
});
/*Get all*/
app.get('/user/api/all', async (req, res) => {
    try {
        const users = await User.find();
        res.json(users);
    } catch (error) {
        res.status(500).json({ message: 'Erreur lors de la récupération des utilisateurs', error });
    }
});
/*Get By Id*/
app.get('/user/api/:id', async (req, res) => {
    try {
        const user = await User.findById(req.params.id);
        if (!user) return res.status(404).json({ message: 'Utilisateur non trouvé' });
        res.json(user);
    } catch (error) {
        res.status(500).json({ message: 'Erreur lors de la récupération de l’utilisateur', error });
    }
});
/*Update*/
app.put('/user/api/:id', async (req, res) => {
    const { name, email, password } = req.body;

    try {
        const user = await User.findByIdAndUpdate(
            req.params.id,
            { name, email, password },
            { new: true, runValidators: true }
        );
        if (!user) return res.status(404).json({ message: 'Utilisateur non trouvé' });
        res.json({ message: 'Utilisateur mis à jour avec succès', user });
    } catch (error) {
        res.status(500).json({ message: 'Erreur lors de la mise à jour de l’utilisateur', error });
    }
});

/*Delete*/
app.delete('/user/api/:id', async (req, res) => {
    try {
        const user = await User.findByIdAndDelete(req.params.id);
        if (!user) return res.status(404).json({ message: 'Utilisateur non trouvé' });
        res.json({ message: 'Utilisateur supprimé avec succès' });
    } catch (error) {
        res.status(500).json({ message: 'Erreur lors de la suppression de l’utilisateur', error });
    }
});


app.listen(port, () => {
    console.log(`Node.js microservice running on port ${port}`);
});


// Configuration du client Eureka

const client = new Eureka({
    instance: {
        app: 'MS-USER',
        hostName: 'user-ms:${port}', // Nom du conteneur pour éviter des problèmes de DNS Docker
        ipAddr: '127.0.0.1',
            port: {
            '$': port,
                '@enabled': true
        },
        vipAddress: 'ms-user',
            statusPageUrl: 'http://localhost:${port}',
            healthCheckUrl: 'http://localhost:${port}/health',
                dataCenterInfo: {
                    '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
                        name: 'MyOwn'
                }
        },
        eureka: {
            host: 'discovery', // Utilisation du nom de service Docker
                port: 8761,
                servicePath: '/eureka/apps/'
        }
    });
