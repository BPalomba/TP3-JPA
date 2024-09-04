package entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor


@Entity
@Table
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int precio;
    private String denominacion;
    private int cantidad;

    @Builder.Default
    @OneToMany(mappedBy = "articulo" , cascade = CascadeType.PERSIST)
    private Set<DetalleFactura> detalleFacturas = new HashSet<>();

    @Builder.Default
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "articulo_categoria",
            joinColumns = @JoinColumn(name = "articulo_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
            )
    private Set<Categoria> categorias = new HashSet<>();

    public Articulo() {
        this.categorias = new HashSet<>();
    }

}
