package tn.backend.MemberService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.backend.MemberService.Entities.*;
import tn.backend.MemberService.Service.IMemberService;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private IMemberService memberService;

    // API pour récupérer tous les membres
    @GetMapping
    public ResponseEntity<List<Member>> findMembers() {
        return ResponseEntity.ok(memberService.findAll());
    }
    // API pour récupérer tous les enseignants
    @GetMapping("/enseignants")
    public ResponseEntity<List<EnseignantChercheur>> findAllEnseignants() {
        return ResponseEntity.ok(memberService.findAllEnseignants());
    }

    // API pour récupérer tous les étudiants
    @GetMapping("/etudiants")
    public ResponseEntity<List<Etudiant>> findAllEtudiants() {
        return ResponseEntity.ok(memberService.findAllEtudiants());
    }


    // API pour compter les enseignants
    @GetMapping("/count/enseignants")
    public ResponseEntity<Long> countEnseignants() {
        return ResponseEntity.ok(memberService.countEnseignants());
    }

    // API pour compter les étudiants
    @GetMapping("/count/etudiants")
    public ResponseEntity<Long> countEtudiants() {
        return ResponseEntity.ok(memberService.countEtudiants());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Member> findOneMemberById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(memberService.findMember(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search/cin")
    public ResponseEntity<Member> findOneMemberByCin(@RequestParam String cin) {
        Member member = memberService.findByCin(cin);
        return member != null ? ResponseEntity.ok(member) : ResponseEntity.notFound().build();
    }

    @GetMapping("/search/email")
    public ResponseEntity<Member> findOneMemberByEmail(@RequestParam String email) {
        Member member = memberService.findByEmail(email);
        return member != null ? ResponseEntity.ok(member) : ResponseEntity.notFound().build();
    }

    @GetMapping("/search/nom")
    public ResponseEntity<List<Member>> findMembersByNom(@RequestParam String nom) {
        return ResponseEntity.ok(memberService.findByNom(nom));
    }

    @PostMapping(value = "/add/enseignant")
    public ResponseEntity<Member> addEnseignant(@RequestBody EnseignantChercheur enseignant) {
        return ResponseEntity.ok(memberService.addMember(enseignant));
    }

    @PostMapping(value = "/add/etudiant")
    public ResponseEntity<Member> addEtudiant(@RequestBody Etudiant etudiant) {
        return ResponseEntity.ok(memberService.addMember(etudiant));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        try {
            memberService.deleteMember(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "/update/etudiant")
    public ResponseEntity<Member> updateEtudiant(@RequestBody Etudiant etudiant) {
        try {
            return ResponseEntity.ok(memberService.updateMember(etudiant));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "/update/enseignant")
    public ResponseEntity<Member> updateEnseignant(@RequestBody EnseignantChercheur enseignant) {
        try {
            return ResponseEntity.ok(memberService.updateMember(enseignant));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
