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
    public Long id;
    public String qarku;
    public Integer rasteGjithsej;
    public Integer sheruar;
    public Integer vdekur;
    public Integer aktPozitive;
    public Integer terapiInt;
    public Integer mjekimSpitalor;
    public Integer izolim;
    public Integer teste;
    public String lat;
    public String lon;
}
