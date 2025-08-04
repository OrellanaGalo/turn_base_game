# Diagrama hecho con Mermaid:

```mermaid
flowchart TD
    A[Object] -.ABSTRACT.-> Item{Item}
    subgraph item
        Item -.ABSTRACT.-> Armadura{Armadura}
        subgraph uno
            Armadura -->|CLASE| Casco[Casco]
            Armadura -->|CLASE| Torso[Torso]
            Armadura -->|CLASE| Pantalon[Pantalon]
            Armadura -->|CLASE| Pies[Pies]
        end
        Item -.ABSTRACT.-> Accesorio{Accesorio}
        subgraph dos
            Accesorio -->|CLASE| Collar[Collar]
            Accesorio -->|CLASE| Amuleto[Amuleto]
        end
        Item -.ABSTRACT.-> Arma{Arma}
        subgraph tres
            Arma -->|CLASE| Lanza[Lanza]
        end
        Item -.ABSTRACT.-> Consumible{Consumible}
        subgraph cuatro
            Consumible -->|CLASE| Pocion[Pocion]
        end
    end
    A[Object] -->|CLASE| Personaje[Personaje]
    A[Object] -->|CLASE| Stat[Stat]
    A[Object] -->|CLASE| Inventario[Inventario]
    A[Object] -->|CLASE| Administrador[Administrador]
    A[Object] -->|CLASE| Juego[Juego]
```


# Implementaciones.

> Justificar la existencia de las clase que heredan Armadura, Arma, Accesorio y Consumible. --> Importante.

> Hacer funcionar el metodo desequiparItem de la clase Personaje y RemoverItemDeEquipamiento de la clase Inventario. No funciona especificamente con las Armas.

> Arreglar error de que un peleador puede pelear contra el mismo.

> Arreglar error al defender que permite que un personaje tenga el buffo de la armadura indefinidamente.

> Agregar metodo para poder volver al menu, para evitar casos de softlock.

> Darle funcionalidad al atributo inteligencia y que sirva para aumentar el ataque, asi como que aumente la probabilidad de golpes criticos.

> Agregar la probabilidad de golpes criticos.
