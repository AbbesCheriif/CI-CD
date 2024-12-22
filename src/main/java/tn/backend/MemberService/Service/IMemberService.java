package tn.backend.MemberService.Service;

import org.springframework.stereotype.Service;
import tn.backend.MemberService.Entities.EnseignantChercheur;
import tn.backend.MemberService.Entities.Etudiant;
import tn.backend.MemberService.Entities.Member;

import java.util.List;


public interface IMemberService {
    //Crud sur les membres
    public Member addMember(Member m);
    public void deleteMember(Long id) ;
    public Member updateMember(Member p) ;
    public Member findMember(Long id) ;
    public List<Member> findAll();
    //Filtrage par propriété
    public Member findByCin(String cin);
    public Member findByEmail(String email);
    public List<Member> findByNom(String nom);
    //recherche spécifique des étudiants
    public List<Etudiant> findByDiplome(String diplome);
    //recherche spécifique des enseignants
    public List<EnseignantChercheur> findByGrade(String grade);
    public List<EnseignantChercheur> findByEtablissement(String etablissement);
    public void affect_etudiantToEnseignant(Long idEns, Long idEtu);
    public List<Etudiant> findByEncadrant(EnseignantChercheur ens);
    List<EnseignantChercheur> findAllEnseignants();
    List<Etudiant> findAllEtudiants();
    long countEnseignants();
    long countEtudiants();
}
