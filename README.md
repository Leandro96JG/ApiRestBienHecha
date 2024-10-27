# Buenas Prácticas al Crear una API REST en SPRING BOOT

# Model
## Entidades

### Entidades en Plural
- Dependiendo el motor de base de datos que se utilice, en este caso MySQL los nombres de las tablas, es recomendable que se escriban en plural en la base de datos, NO en la entidad.
### ``@Data``
- No es recomendable usar la anotación ``@Data`` ya que trae problemas en las relaciones entre entidades con los métodos hashequals. 
### Atributos de precio o dinero
- Para los atributos de tipo precio o manejo de dinero, es recomendable usar el tipo de dato ``BigDecimal``, tiene una mayor precisión.
### Obtener todos los datos de nuestra entidad principal desde una entidad Secundaria ``category_id``
- No hace falta establecer una relación de nuestra entidad principal en nuestra entidad secundaria para saber todos los datos que coincidan, podemos usar métodos de scrip sql.
### Atributos de tipo ``Boolean``
````java
@Column(nullable = false)
private Boolean status;
````
- Esta configuración hace que si el valor es nulo por defecto el boolean es false

## DTO
> Datos que necesitamos enviar o mostrar al front
### Validaciones 
- Para usar validaciones en los DTO necesario agregar la dependecia... 
````xml
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
````
# Service

## Mappers
- Al recibir o enviar datos de tipo DTO en nuestro controladores, en nuestros services, para transformar los datos podríamos hacerlo mediante el patron Builder o usando Mappers.
### MapStruct
- Guía de instalación en la documentación oficial [MapStruct-Install](https://mapstruct.org/documentation/installation/)

# Controller

## Reutilizar nombre de funciones
- Se recomienda usar el mismo nombre de las funciones de los services en los controladores para tener un código más limpio. 