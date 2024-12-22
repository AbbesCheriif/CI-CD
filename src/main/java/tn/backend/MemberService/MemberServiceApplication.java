package tn.backend.MemberService;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cache.annotation.EnableCaching;
import tn.backend.MemberService.Entities.EnseignantChercheur;
import tn.backend.MemberService.Entities.Etudiant;
import tn.backend.MemberService.Entities.Member;
import tn.backend.MemberService.Repositories.EtudiantRepository;
import tn.backend.MemberService.Repositories.MemberRepository;
import tn.backend.MemberService.Service.IMemberService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@EnableCaching
@AllArgsConstructor
//@EnableDiscoveryClient
public class MemberServiceApplication implements CommandLineRunner {

	MemberRepository memberRepository;

	EtudiantRepository etudiantRepository;

	IMemberService ms;

	public static void main(String[] args) {
		SpringApplication.run(MemberServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
/*
		// Créer et enregistrer deux enseignants chercheurs
		EnseignantChercheur enseignant1 = EnseignantChercheur.builder()
				.cin("12398765")
				.nom("slim")
				.prenom("kenoun")
				.dateNaissance(new Date())
				.cv("CV slim")
				.email("slim.kenoun@example.com")
				.password("password1")
				.grade("Professeur")
				.etablissement("Univ A")
				.build();

		EnseignantChercheur enseignant2 = EnseignantChercheur.builder()
				.cin("56789123")
				.nom("tarak")
				.prenom("frikha")
				.dateNaissance(new Date())
				.cv("CV tarak")
				.email("tarak.frikha@example.com")
				.password("password2")
				.grade("Maître de conférences")
				.etablissement("Univ B")
				.build();
		//enregistrer les 2 enseigants
		memberRepository.save(enseignant1);
		memberRepository.save(enseignant2);

		// création de 2 étudiants
		Etudiant etudiant1 = Etudiant.builder()
				.cin("12398765")
				.nom("cherif")
				.prenom("abbes")
				.dateNaissance(new Date())
				.cv("CV cherif")
				.email("cherif.abbes@example.com")
				.password("password3")
				.dateInscription(new Date())
				.sujet("Devops")
				.diplome("ingénieur")
				.encadrant(enseignant1)
				.build();

		Etudiant etudiant2 = Etudiant.builder()
				.cin("56789123")
				.nom("ala")
				.prenom("dammak")
				.dateNaissance(new Date())
				.cv("CV ala")
				.email("ala.dammak@example.com")
				.password("password4")
				.dateInscription(new Date())
				.sujet("Thèse A")
				.diplome("master")
				.encadrant(enseignant2)
				.build();
		//enregistrer les 2 étudiants
		memberRepository.save(etudiant1);
		memberRepository.save(etudiant2);

		// Afficher la liste des membres
		System.out.println("Liste des membres dans le laboratoire :");
		memberRepository.findAll().forEach(System.out::println);

		// Chercher un membre par ID
		Long idEtudiant1 = etudiant1.getId();
		Optional<Member> membre = memberRepository.findById(idEtudiant1);
		membre.ifPresentOrElse(
				m -> System.out.println("Membre trouvé : " + m),
				() -> System.out.println("Membre avec ID " + idEtudiant1 + " non trouvé.")
		);

		// Modifier un membre
		if (membre.isPresent()) {
			Member membreAModifier = membre.get();
			membreAModifier.setEmail("nouveau.email@example.com");
			memberRepository.save(membreAModifier);
			System.out.println("Membre modifié : " + membreAModifier);
		}


		 Supprimer un membre
		Long idASupprimer = etudiant2.getId(); // exemple avec l'ID de l'étudiant2
		memberRepository.deleteById(idASupprimer);
		System.out.println("Membre avec ID " + idASupprimer + " supprimé.");


		ms.affect_etudiantToEnseignant(enseignant1.getId(), etudiant1.getId());

		List<Etudiant> le = ms.findByEncadrant( enseignant1);


		for (Etudiant etudiant : le) {
			System.out.println("Nom : " + etudiant.getNom() + ", Prénom : " + etudiant.getPrenom());
		}
*/
	}
}
