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
@Table(name = "qarku")
public class Qarku {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long Id;
    public String qarku;
    public Integer raste_gjithsej;
    public Integer sheruar;
    public Integer vdekur;
    public Integer akt_pozitive;
    public Integer terapiInt;
    public Integer mjekim_spitalor;
    public Integer izolim;
    public Integer teste;
    public String lat;
    public String lon;
}
