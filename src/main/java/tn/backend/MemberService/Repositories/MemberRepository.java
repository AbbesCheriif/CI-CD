package tn.backend.MemberService.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.backend.MemberService.Entities.EnseignantChercheur;
import tn.backend.MemberService.Entities.Etudiant;
import tn.backend.MemberService.Entities.Member;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long>
{
    Member findByCin(String cin);
    List<Member> findByNomStartingWith(String caractere);
    Member findByEmail(String email);

    List<Member> findByNom(String nom);

    List<Etudiant> findByDiplome(String diplome);

    List<EnseignantChercheur> findByGrade(String grade);

    List<EnseignantChercheur> findByEtablissement(String etablissement);

    @Query("SELECT m.id, m.nom, m.prenom FROM Member m")
    List<Member> findBasicMemberInfo();
}
