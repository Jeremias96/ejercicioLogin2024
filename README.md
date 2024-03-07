# Ejercicio Login 

Proyecto usado como ejercicio basado en un login con los endpoint /sign-up y /login

Utiliza Java 11 y Springboot 2.7

## Para limpiar /build:

```
/gradlew clean
```

## Para compilar y correr tests:

```
/gradlew build
```

## Para compilar sin tests:

```
/gradlew build --x test
```

## Para ejecutar:
```
/gradlew bootrun
```

## Endpoints:

**/v1/sign-up** : Registra un nuevo usuario

- Recibe un nombre, email, password y lista de telefonos. El password debe tener una sola mayúscula y solamente dos números no necesariamente consecutivos, en combinación con letras minúsculas, largo máximo de 12 y mínimo 8. Ejemplo:

```
{
    "name": "User Test",
    "email": "user@test.com",
    "password": "1d2Eabcdef",
    "phones": [
        {
            "number": 123456789,
            "citycode": 2966,
            "countrycode": "+54"
        }
    ]
}
```

- Devuelve el usuario creado:

```
{
    "id": "98b07092-7ef4-4d41-a6a6-c2b0ee61efb5",
    "created": "2023-03-20T22:55:47.087Z",
    "lastLogin": "2023-03-20T22:55:47.087Z",
    "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJKZXJlbWlhc0xlaXRvbiIsImVtYWlsIjoiamVyZW1pYXNAbGVpdG9uLmNvbSIsImp0aSI6ImIzZGYxMGJjLWVkMGItNDc1ZS1hYzljLWJlNDA5ODE3M2FkNCJ9._rCYSl7G_pgD2eFbbkuyipoK0FzUvA9Vo8GZ_dpApwI",
    "isActive": true
}
```

**/v1/login** : Verifica un usuario ya registrado

- Recibe un token de login:

```
{
    "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJKZXJlbWlhc0xlaXRvbiIsImVtYWlsIjoiamVyZW1pYXNAbGVpdG9uLmNvbSIsImp0aSI6ImIzZGYxMGJjLWVkMGItNDc1ZS1hYzljLWJlNDA5ODE3M2FkNCJ9._rCYSl7G_pgD2eFbbkuyipoK0FzUvA9Vo8GZ_dpApwI"
}
```

- Devuelve el usuario guardado:

```
{
    "id": "98b07092-7ef4-4d41-a6a6-c2b0ee61efb5",
    "created": "2023-03-20T22:55:47.087Z",
    "lastLogin": "2023-03-21T00:07:40.493Z",
    "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJKZXJlbWlhc0xlaXRvbiIsImVtYWlsIjoiamVyZW1pYXNAbGVpdG9uLmNvbSIsImp0aSI6ImExYjNiZmExLTZlMWItNGE3ZS1iYWU1LWJjODE1NzE3YzgxYSJ9.kP0tQd-8aHswCkueaST91ulBXobg-76ZS5rZaZ3638M",
    "isActive": true,
    "name": "User Test",
    "email": "user@test.com",
    "password": "dEjpfjL8hgYlrfx5kFPIEw==",
    "phones": [
        {
            "number": 123456789,
            "cityCode": 2966,
            "countryCode": "+54"
        }
    ]
}
```
