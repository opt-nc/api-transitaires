[![semantic-release](https://img.shields.io/badge/%20%20%F0%9F%93%A6%F0%9F%9A%80-semantic--release-e10079.svg)](https://github.com/semantic-release/semantic-release)
[![Test, Release](https://github.com/opt-nc/api-transitaires/actions/workflows/test-release.yml/badge.svg)](https://github.com/opt-nc/api-transitaires/actions/workflows/test-release.yml)
[![Docker Image](https://img.shields.io/badge/docker-homepage-blue)](https://hub.docker.com/r/optnc/api-transitaires)
![Docker Pulls](https://img.shields.io/docker/pulls/optnc/api-transitaires)
![Docker Image Size (latest by date)](https://img.shields.io/docker/image-size/optnc/api-transitaires)
![Docker Stars](https://img.shields.io/docker/stars/optnc/api-transitaires)
![Docker Image Version (latest by date)](https://img.shields.io/docker/v/optnc/api-transitaires?arch=amd64&sort=date)
![GitHub Repo stars](https://img.shields.io/github/stars/opt-nc/api-transitaires?style=social)

# ❔ A propos

API qui renvoie les transitaires de dédouanement 🚢 en Nouvelle-Calédonie.

# 🚀 Utilisation

```sh
docker run --rm -it -p 8880:8080 docker.io/optnc/api-transitaires:latest
http :8080/transitaires
````

- 📖 Swagger : http://localhost:8080/q/swagger-ui
- 💻 Front-end web : http://localhost:8080
- ❤️‍🩹 Endpoit d'état : http://localhost:8080/q/health
