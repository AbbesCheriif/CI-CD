package tn.backend.MemberService.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor

@DiscriminatorValue("etd")
public class Etudiant extends Member{
    @ManyToOne
    private EnseignantChercheur encadrant;

    @NonNull
    private Date dateInscription;
    @NonNull
    private String sujet;
    @NonNull
    private String diplome;
    @Builder
    public Etudiant( String cin, String nom, String prenom, Date dateNaissance, String cv, String email, String password, Date dateInscription, String sujet, String diplome, EnseignantChercheur encadrant) {
        super( cin, nom, prenom, dateNaissance, cv, email, password);
        this.dateInscription = dateInscription;
        this.sujet = sujet;
        this.diplome = diplome;
        this.encadrant = encadrant;
    }
}
