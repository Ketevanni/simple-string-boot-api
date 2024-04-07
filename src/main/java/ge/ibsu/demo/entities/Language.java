package ge.ibsu.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "language")
public class Language {
    @Id
    @SequenceGenerator(name = "language_language_id_seq", sequenceName = "language_language_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "language_language_seq")
    @Column(name = "language_id")
    private Long id;

    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
