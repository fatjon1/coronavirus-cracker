package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class StatistikaKategori {
    @Id
    protected String datat;
    protected Integer rasteAktive;
    protected Integer rasteTeReja;
    protected Integer rastetKumulative;
    protected Integer vdekjeKumulative;
    protected Integer sheruar;
}
