package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class StatistikaKategori {
    @Id
    @Column(name = "date_id", length = 10)
    protected String datat;
    protected Integer raste_aktive;
    protected Integer raste_te_reja;
    protected Integer rastet_kumulative;
    protected Integer vdekje_kumulative;
    protected Integer sheruar;
}
