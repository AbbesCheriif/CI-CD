package tn.backend.MemberService.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import tn.backend.MemberService.Entities.Etudiant;
import tn.backend.MemberService.Entities.EnseignantChercheur;
import tn.backend.MemberService.Entities.Member;
import tn.backend.MemberService.Service.IMemberService;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class MemberControllerTest {

    @InjectMocks
    private MemberController memberController;

    @Mock
    private IMemberService memberService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindMembers() {
        // Préparer des données fictives pour les membres
        EnseignantChercheur enseignant = EnseignantChercheur.builder()
                .cin("123456")
                .nom("Doe")
                .prenom("John")
                .dateNaissance(new Date())
                .cv("cv1.pdf")
                .email("john.doe@example.com")
                .password("password123")
                .grade("Professeur")
                .etablissement("Université XYZ")
                .build();

        Etudiant etudiant = Etudiant.builder()
                .cin("654321")
                .nom("Smith")
                .prenom("Anna")
                .dateNaissance(new Date())
                .cv("cv2.pdf")
                .email("anna.smith@example.com")
                .password("password456")
                .dateInscription(new Date())
                .sujet("IA et Big Data")
                .diplome("Master")
                .encadrant(enseignant)
                .build();

        List<Member> mockMembers = Arrays.asList(enseignant, etudiant);
        when(memberService.findAll()).thenReturn(mockMembers);

        ResponseEntity<List<Member>> response = memberController.findMembers();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().size());
        assertEquals("Doe", ((EnseignantChercheur) response.getBody().get(0)).getNom());
        assertEquals("Smith", ((Etudiant) response.getBody().get(1)).getNom());
    }

    @Test
    void testFindAllEnseignants() {
        EnseignantChercheur enseignant = EnseignantChercheur.builder()
                .cin("123456")
                .nom("Doe")
                .prenom("John")
                .dateNaissance(new Date())
                .cv("cv1.pdf")
                .email("john.doe@example.com")
                .password("password123")
                .grade("Professeur")
                .etablissement("Université XYZ")
                .build();

        List<EnseignantChercheur> mockEnseignants = Arrays.asList(enseignant);
        when(memberService.findAllEnseignants()).thenReturn(mockEnseignants);

        ResponseEntity<List<EnseignantChercheur>> response = memberController.findAllEnseignants();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
        assertEquals("Doe", response.getBody().get(0).getNom());
    }

    @Test
    void testFindAllEtudiants() {
        Etudiant etudiant = Etudiant.builder()
                .cin("654321")
                .nom("Smith")
                .prenom("Anna")
                .dateNaissance(new Date())
                .cv("cv2.pdf")
                .email("anna.smith@example.com")
                .password("password456")
                .dateInscription(new Date())
                .sujet("IA et Big Data")
                .diplome("Master")
                .build();

        List<Etudiant> mockEtudiants = Arrays.asList(etudiant);
        when(memberService.findAllEtudiants()).thenReturn(mockEtudiants);

        ResponseEntity<List<Etudiant>> response = memberController.findAllEtudiants();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
        assertEquals("Smith", response.getBody().get(0).getNom());
    }

    @Test
    void testFindOneMemberByCin() {
        EnseignantChercheur enseignant = EnseignantChercheur.builder()
                .cin("123456")
                .nom("Doe")
                .prenom("John")
                .dateNaissance(new Date())
                .cv("cv1.pdf")
                .email("john.doe@example.com")
                .password("password123")
                .grade("Professeur")
                .etablissement("Université XYZ")
                .build();

        when(memberService.findByCin("123456")).thenReturn(enseignant);

        ResponseEntity<Member> response = memberController.findOneMemberByCin("123456");

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Doe", response.getBody().getNom());
    }

    @Test
    void testAddEnseignant() {
        EnseignantChercheur enseignant = EnseignantChercheur.builder()
                .cin("123456")
                .nom("Doe")
                .prenom("John")
                .dateNaissance(new Date())
                .cv("cv1.pdf")
                .email("john.doe@example.com")
                .password("password123")
                .grade("Professeur")
                .etablissement("Université XYZ")
                .build();

        when(memberService.addMember(enseignant)).thenReturn(enseignant);

        ResponseEntity<Member> response = memberController.addEnseignant(enseignant);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Doe", response.getBody().getNom());
    }

    @Test
    void testAddEtudiant() {
        EnseignantChercheur enseignant = EnseignantChercheur.builder()
                .cin("123456")
                .nom("Doe")
                .prenom("John")
                .dateNaissance(new Date())
                .cv("cv1.pdf")
                .email("john.doe@example.com")
                .password("password123")
                .grade("Professeur")
                .etablissement("Université XYZ")
                .build();

        Etudiant etudiant = Etudiant.builder()
                .cin("654321")
                .nom("Smith")
                .prenom("Anna")
                .dateNaissance(new Date())
                .cv("cv2.pdf")
                .email("anna.smith@example.com")
                .password("password456")
                .dateInscription(new Date())
                .sujet("IA et Big Data")
                .diplome("Master")
                .encadrant(enseignant)
                .build();

        when(memberService.addMember(etudiant)).thenReturn(etudiant);

        ResponseEntity<Member> response = memberController.addEtudiant(etudiant);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Smith", response.getBody().getNom());
    }

    /*@Test
    void testDeleteMember() {
        long memberId = 1L;
        when(memberService.deleteMember(memberId)).thenReturn(null);

        ResponseEntity<Void> response = memberController.deleteMember(memberId);

        assertEquals(204, response.getStatusCodeValue()); // No content
    }

    @Test
    void testDeleteMemberNotFound() {
        long memberId = 999L;
        when(memberService.deleteMember(memberId)).thenThrow(new IllegalArgumentException("Member not found"));

        ResponseEntity<Void> response = memberController.deleteMember(memberId);

        assertEquals(404, response.getStatusCodeValue()); // Not Found
    }*/
}
