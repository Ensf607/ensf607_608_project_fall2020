# Setup Note

Go to port after install

```
http://localhost:8080/
```









# Connect to GitHub

### GitHub Personal Access Tokens

Generate a token under:

```
Settings / Developer settings / Personal access token / New personal access token
```

the generated token looks like a hash string, store this safely. example:

```
263604fcf22eb870452d1ddafc072cefd5841d37
```

### Setup token in Jenkins

Go to `Jenkins`

- Go to `credentials` > `System` > `Global credentials` > `Add credentials` a page will open.
- In **Kind** drop-down select **Username and password**.
- In User put a non-existing username like `jenkins-user` or `user`.
- Add `Personal Access Token` in the password field

extras

- [source](https://stackoverflow.com/questions/61105368/how-to-use-github-personal-access-token-in-jenkins)

- [alternative method](https://plugins.jenkins.io/github/)

- [github jenkins plugin](https://plugins.jenkins.io/github-oauth/)

note: when adding repo url, it has to be the **git https url** i.e. [(ref)](https://dzone.com/articles/deploying-machine-learning-workflows-on-lke-with-k)

```
https://github.com/stancsz/ensf607_608_project_fall2020.git
```



# Extra setup guide

[guru99 source](https://www.guru99.com/create-builds-jenkins-freestyle-project.html)



# Shell script for server to run
```
mvn -v
echo "building maven package"
mvn package
echo "initing server"
java -cp target/toolshop-server-1.0-SNAPSHOT.jar server.controller.ServerController 
```
