package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
public class StatistikaKategori {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected Date datat;
    protected Integer raste_aktive;
    protected Integer raste_te_reja;
    protected Integer rastet_kumulative;
    protected Integer vdekje_kumulative;
    protected Integer sheruar;
}
