const express = require('express');
const app = express();
const port = 3000;
const { Eureka } = require('eureka-js-client'); // Importer Eureka client
const Keycloak = require('keycloak-connect');
const session = require('express-session');




app.get('/user/api/data', (req, res) => {
    res.json({ message: 'Hello from Node.js microservice!' });
});

app.listen(port, () => {
    console.log(`Node.js microservice running on port ${port}`);
});

// Configuration du client Eureka
const client = new Eureka({
    instance: {
        app: 'MS-USER', // Nom du service dans Eureka
        hostName: `localhost:MS-User:${port}`,
        ipAddr: '127.0.0.1',
        port: {
            '$': port,
            '@enabled': true
        },
        vipAddress: 'ms-user',
        statusPageUrl: `http://localhost:${port}`,
        healthCheckUrl: `http://localhost:${port}/health`,
        dataCenterInfo: {
            '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
            name: 'MyOwn'
        }
    },
    eureka: {
        host: 'localhost',
        port: 8761, // Port d’Eureka Server
        servicePath: '/eureka/apps/'
    }
});

// Démarrer l’enregistrement dans Eureka
client.start(error => {
    console.log(error ? `Erreur lors de l’enregistrement dans Eureka: ${error}` : 'Enregistré avec succès dans Eureka');
});

