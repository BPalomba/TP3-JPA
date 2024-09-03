package entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Detalle_Factura")
public class DetalleFactura implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cantidad;
    private int subtotal;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_articulo")
    private Articulo articulo;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "detalle_fk_factura")
    private Factura factura;

}
