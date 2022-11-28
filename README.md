# grpc-atelier

site de gRPC : grpc.io

site générateur de csv: https://markbdsouza.github.io/csv-data-generator/

INTRO
ici on va tester la pérformance entre du gRPC et du JSON envoyé via HTTP.

Pour ce faire on va lire une fichier CSV, ce fichier contient des infos utilisateurs.
Il y a 5 colonnes :
-prénom
-nom
-email
-age

Récupération des données à envoyer :

On va dans un premier temps lire le fichier csv pour parser les données afin de les envoyées via gRPC mais aussi via JSON/HTTP.
Coté client on va s'amuser à mesurer le temps entre l'envoie de la requete et la réception de la réponse.

Pour ce faire, il vosu faut soit cloner ce repo où j'ai déjà fait la partie lecture ou créer votre projet dans une techno qui vous plait et qui est prend en charge gRPC et HTTP/JSON.

Ressource nécéssaires (dépendances/plugins) :
La prochaine étape de la mission est d'importer les dépendances nécéssaires à mise en place de l'envoie et réception de donnée gRPC. De plus il faut ajouteer les plugins qui premettront, lors du build, de générer vos fichiers (.java dans mon cas) à partir de vos fichiers .proto.

dépendances pour java/kotlin et maven :

  <dependency>
      <groupId>io.grpc</groupId>
      <artifactId>grpc-netty-shaded</artifactId>
      <version>1.37.0</version>
  </dependency>
  <dependency>
      <groupId>io.grpc</groupId>
      <artifactId>grpc-protobuf</artifactId>
      <version>1.37.0</version>
  </dependency>
  <dependency>
      <groupId>io.grpc</groupId>
      <artifactId>grpc-stub</artifactId>
      <version>1.37.0</version>
  </dependency>
  <dependency>
      <groupId>javax.annotation</groupId>
      <artifactId>javax.annotation-api</artifactId>
      <version>1.3.2</version>
  </dependency>

balises build incluant les plugins nécéssaires toujours pour java/kotlin maven:

<build>
    <extensions>
      <extension>
        <groupId>kr.motd.maven</groupId>
        <artifactId>os-maven-plugin</artifactId>
        <version>1.7.0</version>
      </extension>
    </extensions>
    <plugins>
      <plugin>
        <groupId>org.xolstice.maven.plugins</groupId>
        <artifactId>protobuf-maven-plugin</artifactId>
        <version>0.6.1</version>
        <configuration>
          <protocArtifact>
						com.google.protobuf:protoc:3.6.1:exe:${os.detected.classifier}
          </protocArtifact>
          <pluginId>grpc-java</pluginId>
          <pluginArtifact>
						io.grpc:protoc-gen-grpc-java:1.22.1:exe:${os.detected.classifier}
          </pluginArtifact>
          <protoSourceRoot>
					    ${basedir}/src/main/proto/
          </protoSourceRoot>
        </configuration>
        <executions>
          <execution>
            <goals>
              <goal>compile</goal>
              <goal>compile-custom</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
    </plugins>
  </build>

Pour d'autres technos, il est possible visiter le site de gRPC ( grpc.io )

Création du fichier proto :
Pour ateindre notre mission il nous faut ensuite écrire notre fichier .proto ou on définira nos messages, le service et ces méthodes. (le fichier s'appelera User.proto)

Compiler :
Une fois fait il faut compiler le projet afin d'avoir les classes et interfaces java qui nous permettront de mettre en place le serveur, le client mais aussi la sérialisation et déserialisation des données.

Parser :
La méthode qui parse les données du fichier csv vous retourne une liste de proto.User, qui correspont à la classe générée par le plugin proto et qui vous permettra de construire le message final qui sera envoyé en réponse de lé requete.

Envoie :

L'étape suivante est donc de construire la réponse la requete qui nous permettra de renvoyer une liste de User en gRPC.
Une fois notre réponse prete, il nous reste plus qu'à envoyer le message à l'aide des ressources gRPC

Demande/Réception :
Pour l'envoie de notre message on aura juste besoin de préparer notre parametre de requete.
Et effectuer une requete au serveur tout en mesurant le temps de réponse. (ici un launcher suffit, pas besoin de serveur)

REST :

Pour la partie JSON/HTTP j'utilise spring afin de mettre en place un serveur REST rapidos mais aussi pour ne pas recoder la lecture du csv dans une autre techno
Du coup vous savez tous plus ou moins quoi faire ensuite :

on récupere lês donnée du csv puis on les parses afin de les envoyer en body de la réponse.

Ensuite on met en place la route qui appelera le process.

Puis le client vous avez le choix entre PostMan, thunderClient afin de visualiser le temps de réponse.
