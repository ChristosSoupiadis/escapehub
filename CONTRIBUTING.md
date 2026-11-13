# Οδηγός συνεργασίας

## Κανόνες (από την εκφώνηση, §4.2)

- Ο κλάδος `main` είναι **προστατευμένος**: κανένα απευθείας push.
- Κάθε αλλαγή γίνεται με **pull request** που συνδέεται με **issue**, περνά το **CI** και εγκρίνεται από **τουλάχιστον ένα άλλο μέλος**.
- Ο `main` μένει πάντα σε εκτελέσιμη κατάσταση.

## Ροή εργασίας για κάθε issue

1. Αναθέστε στον εαυτό σας το issue και μετακινήστε το στο **In Progress** στο board.
2. Ενημερώστε τον τοπικό `main`:
   IntelliJ → *Git → Branches → main → Checkout*, μετά *Git → Pull*.
3. Νέο branch από τον `main`:
   IntelliJ → *Git → New Branch* → `feature/<αρ. issue>-<σύντομη-περιγραφή>`
   π.χ. `feature/12-register-user`, `fix/31-journal-conflict`, `docs/7-api-research`.
4. Μικρά commits με νόημα (βλ. παρακάτω). *Git → Commit* (Ctrl+K), *Git → Push* (Ctrl+Shift+K).
5. Τρέξτε τοπικά `mvn verify` πριν ανοίξετε PR.
6. Στο GitHub: **Compare & pull request**. Συμπληρώστε **όλο** το template, μαζί με το πεδίο χρήσης AI.
   Γράψτε `Closes #12` ώστε το issue να κλείσει αυτόματα.
7. Ζητήστε review από τον reviewer του issue. Μετακινήστε το issue στο **Review**.
8. Μετά από approval και πράσινο CI: **Squash and merge**. Το branch σβήνεται αυτόματα.

## Μηνύματα commit (Conventional Commits)

```
<τύπος>: <τι άλλαξε> (#issue)
```

| Τύπος | Πότε |
|---|---|
| `feat` | νέα λειτουργία |
| `fix` | διόρθωση bug |
| `test` | προσθήκη ή αλλαγή tests |
| `refactor` | αλλαγή κώδικα χωρίς αλλαγή συμπεριφοράς |
| `docs` | τεκμηρίωση |
| `ci` / `build` | pipeline, Maven, Docker |
| `chore` | λοιπά |

Παράδειγμα: `feat: εγγραφή χρήστη με BCrypt (#12)`

## Code review (§4.5)

Κάθε μέλος κάνει **τουλάχιστον 2 ουσιαστικά reviews ανά sprint** σε PRs άλλων μελών.
Ουσιαστικό review σημαίνει: τρέχετε τον κώδικα ή τα tests, ελέγχετε τα acceptance criteria, σχολιάζετε
συγκεκριμένες γραμμές. Ένα σκέτο "LGTM" δεν μετράει.

Σημεία ελέγχου:
- Καλύπτονται τα acceptance criteria από tests;
- Υπάρχουν tests για σφάλματα και οριακές περιπτώσεις;
- Είναι κατανοητά τα ονόματα και η δομή;
- Ενημερώθηκαν README / OpenAPI / CHANGELOG όπου χρειάζεται;
- Αν χρησιμοποιήθηκε AI: είναι σαφές πώς επαληθεύτηκε το αποτέλεσμα;

## Εκδόσεις (Semantic Versioning)

Στο τέλος κάθε sprint, ο Scrum Master:
1. Μεταφέρει τις αλλαγές από `[Unreleased]` σε νέα ενότητα `## [X.Y.Z] - ΗΗΗΗ-ΜΜ-ΗΗ` στο `CHANGELOG.md` (με PR).
2. Μετά το merge: IntelliJ → *Git → New Tag* → `vX.Y.Z` πάνω στον `main`, και *Git → Push* με επιλογή **Push Tags**.
   Από γραμμή εντολών: `git tag v0.2.0 && git push origin v0.2.0`.
3. Το pipeline `Release` φτιάχνει αυτόματα το GitHub release και το Docker image.

| Sprint | Έκδοση |
|---|---|
| 0 | v0.1.0 |
| 1 | v0.2.0 |
| 2 | v0.3.0 |
| 3 | v0.4.0 |
| 4 | v1.0.0 |

## Ευθύνες Scrum Master (εναλλάσσεται κάθε sprint)

- Οργανώνει Sprint Planning, Review, Retrospective.
- Κρατά το board ενημερωμένο και επισημαίνει μπλοκαρισμένα issues.
- Φροντίζει να ενημερωθεί το AI-usage log και να γίνει το release.
- Ενημερώνει έγκαιρα τον διδάσκοντα για προβλήματα συνεργασίας.

## Χρήση AI

Βλ. [docs/ai-usage-log.md](docs/ai-usage-log.md). Ποτέ κωδικοί, API keys ή προσωπικά δεδομένα σε prompts.
Κάθε μέλος πρέπει να μπορεί να εξηγήσει κάθε γραμμή του κώδικα που παραδίδει ή εγκρίνει.
