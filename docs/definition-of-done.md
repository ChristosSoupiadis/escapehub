# Definition of Done

Ένα user story θεωρείται **Done** μόνο όταν ισχύουν όλα τα παρακάτω:

- [ ] Τα acceptance criteria καλύπτονται από αυτοματοποιημένα tests που περνούν.
- [ ] Ο κώδικας μπήκε στον `main` μέσω pull request με εγκεκριμένο review από άλλο μέλος.
- [ ] Το CI (build, tests, Checkstyle, SpotBugs) είναι πράσινο.
- [ ] Η σχετική τεκμηρίωση (README, OpenAPI, CHANGELOG) ενημερώθηκε όπου χρειάζεται.
- [ ] Το PR αναφέρει το issue (`Closes #N`) και έχει συμπληρωμένο το πεδίο χρήσης AI.
- [ ] Τα tests δεν καλούν ζωντανά δημόσια APIs (χρησιμοποιούν mocks ή fixtures).

Η ομάδα αναθεωρεί τον DoD στα retrospectives.
