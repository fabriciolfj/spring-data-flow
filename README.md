# Spring Data flow
- Exemplo de aplicações personalizadas, integrando com spring data flow.


### Configuração (branch rabbit)
- Execute o install ssh que encontra-se no diretório workspace-rabbit-mysql-monitoring. obs: utilizei o multipass para montagem do ambiente local kubernetes
- Crie imagens das aplicações movie-sink, movie-processor e movie-source. mvn clean install spring-boot:boot-image
- Suba no docker hub. docker push id/nome da imagem:versao
- Configure as aplicações no spring-data-flow (http://localhost:9393/dashboard add app), utilizando docker. Exemplo: docker://fabricio211/movie-processor:0.0.5-SNAPSHOT
- Crie o stream abaixo:
```
movie-source | movie-processor | movie-sink
```
- Adicione a configuração abaixo, na aba text no momento da criação do stream
```
app.movie-processor.movie.header-key=e1d57bc780msh2ab0500b21047acp10b199jsnd21a2e07bb7e
app.movie-processor.spring.cloud.stream.bindings.input.destination=movie
app.movie-processor.spring.cloud.stream.bindings.output.destination=log
app.movie-sink.spring.cloud.stream.bindings.input.destination=log
app.movie-source.server.port=8080
app.movie-processor.server.port=8080
app.movie-sink.server.port=8080
app.movie-source.spring.cloud.stream.bindings.output.destination=movie
spring.cloud.dataflow.skipper.platformName=default
```
- Aponte para o pod source, afim de testar o fluxo: kubectl port-forward pod/movie-movie-source-v8-685684d9f7-gmsz2 9090:8080
- Payload sugerido: post localhost:9090/v1/api/movies
```
{
    "action": "create",
    "movies": [
        {
            "id": "tt0133093",
            "title": "The Matrix",
            "actor": "Keanu Reeves",
            "year": 1999,
            "genre": "fiction",
            "stars": 5
        },
        {
            "id": "tt0209144",
            "title": "Memento",
            "actor": "Guy Pearce",
            "year": 2000,
            "genre": "drama",
            "stars": 4
        }
    ]
}
```
