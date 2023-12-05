DROP TABLE IF EXISTS Videojuegos;
DROP TABLE IF EXISTS Desarrolladores;


CREATE TABLE Desarrolladores (
    id INT PRIMARY KEY,
    nombre VARCHAR(255),
    pais VARCHAR(255),
  id_Videojuego int,
  FOREIGN KEY (id_Videojuego) REFERENCES Videojuegos(id)
);
CREATE TABLE Videojuegos (
    id INT PRIMARY KEY,
    titulo VARCHAR(255),
    genero VARCHAR(255),
    precio DECIMAL(10, 2),
    imagen VARCHAR(255),
  	id_Desarrollador INT
);
 
INSERT INTO Videojuegos (id, titulo, genero, precio,imagen,id_Desarrollador) VALUES
(1, 'Call Of Dutty', 'FPS',79.99,'https://esports.as.com/2020/08/21/call-of-duty/Todas-portadas-Call-of-Duty_1384671545_481695_1024x1365.jpg',1 ),
(2, 'Warthunder', 'Aviación',20.99,'https://estaticos-cdn.sport.es/clip/f1ed6a3d-8068-4be4-85e2-90426ae059a2_alta-libre-aspect-ratio_default_0.jpg',2 ),
(3, 'Assasins Creed', 'Action-Adventure',49.99,'https://www.esferalibros.com/wp-content/uploads/2021/04/principal-portada-assasins-creed-unity-es-662x1024.jpg',3 );

INSERT INTO Desarrolladores(id, nombre, pais,id_Videojuego) VALUES
(1, 'David Bonderhart','Estados Unidos',1),
(2, 'Alice Johnson','Canadá',1),
(3, 'Gaying','Rusia',2),
(4,'Maria Rodriguez','Francia',3);

 
