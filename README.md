# TP4 - Chat UDP en Java

## Étudiante

- Nom : Baha Essid
- Classe : LSI3
- Matière : Développement d'Applications Réparties
- TP4 : Sockets en mode non connecté (UDP)

# Structure du projet

```text
TP4_REP
│
├── clientPackage
│   ├── Client.java
│   └── Client_4_2.java
│
├── serverPackage
│   ├── Server.java
│   └── Serveur_4_2.java
│
└── pom.xml
```
# Résultat d'exécution

## Exécution du serveur

```text
Serveur UDP démarré sur le port 1234...

Message reçu de 127.0.0.1:52140 -> Baha : Bonjour
Message reçu de 127.0.0.1:52155 -> Bochra : Salut
```

## Exécution du client Baha

```text
Nom utilisateur : Baha

> Bonjour

Bochra : Salut
```

## Exécution du client Bochra

```text
Nom utilisateur : Bochra

Baha : Bonjour

> Salut
```

## Test réalisé

- Démarrage du serveur sur le port 1234.
- Connexion de plusieurs clients.
- Envoi de messages depuis chaque client.
- Réception correcte des messages par le serveur.
- Affichage des messages reçus par les autres clients.

## Conclusion

L'application fonctionne correctement. Les messages envoyés par les clients sont transmis au serveur via UDP puis affichés dans la console. Le serveur reçoit et traite les datagrammes sans connexion préalable.
