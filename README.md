# juego_paradigmas
TP de paradigmas de programación IFTS
Juego: Tetris!

El tradicional juego de tetris, recreado desde 0 usando matrices.

Pantalla de inicio: 

![Captura1](https://user-images.githubusercontent.com/82178152/145593616-5157739f-b7ec-44b5-a921-dd718322cdf6.JPG)

Apenas comienza el juego, empezamos en nivel 1 y comienza a contarse el tiempo.

![Captura2](https://user-images.githubusercontent.com/82178152/145593697-9e0cddc5-92df-4cc3-8bc0-923ecf9ec11d.JPG)

Se tiene registro de la cantidad de lineas hechas y el puntaje, que varía según las lineas hechas en un turno. Si es una linea sola, se suman 10 puntos. Entre 2 y 3 lineas, 15 puntos por cada una, y cuando se hacen 4 lineas son 20 puntos por cada una. Al subir el puntaje, va subiendo el nivel de dificultad con la velocidad de caida de las fichas.

![Captura3](https://user-images.githubusercontent.com/82178152/145593899-a7aae0eb-6fd1-4b37-bdef-94ecf7fc5277.JPG)

Es posible pausar el juego y luego retomarlo.

Se pausa ⏸ con tecla P

Se vuelve a retomar con tecla enter ↩

![Captura4](https://user-images.githubusercontent.com/82178152/145594042-0e42d53a-cea9-4361-ae34-9a02c1f3daef.JPG)

El jugador pierde cuando la matriz de juego se llena hasta su borde superior. En ese momento se le da la oportunidad de volver al inicio e intentar de nuevo.
Con tecla R puede volver a jugar 

![Captura5](https://user-images.githubusercontent.com/82178152/145594100-00683356-c45b-419a-a817-e2aeb4b1f6bb.JPG)


Diagrama de clases:

![DiagramaTetris2](https://user-images.githubusercontent.com/82178152/145629427-f2f99358-8ab5-4dd5-aca6-823ec5333b63.png)

