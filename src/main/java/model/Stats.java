package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Stats {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    //public Tabs tabs;
    public String[] kategorite = null;
    public Integer[] raste_aktive = null;
    public Integer[] raste_te_reja = null;
    public Integer[] raste_kumulative = null;
    public Integer[] vdekje_kumulative = null;
    public Integer[] sheruar = null;

}
