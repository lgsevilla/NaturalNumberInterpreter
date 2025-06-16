# NumberInterpreter

A simple Java console application built with Maven that interprets a sequence of digit blocks as potential phone numbers. The app intelligently explores ambiguities inspired by Greek number pronunciation conventions — for example, the input 69 might represent 69, 60 9, or even trigger deeper decompositions like 600 9. It validates each interpretation to determine whether it forms a valid 10- or 14-digit phone number.

---

## Features

- Accepts user input as blocks of 1–3 digit numbers (e.g. `2 10 69 30 6 6 4`)
- Outputs all valid and ambiguous interpretations of the number sequence
- Validates interpretations as phone numbers:
  - ✅ 10-digit numbers (standard phone number)
  - ✅ 14-digit numbers (international format with country code)
- Modular design:
  - `NumberInterpreter`: Handles input/output and delegates interpretation
  - `AmbiguityInterpreter`: Generates all valid ambiguous interpretations
  - `BasePhoneValidator`: Validates whether a sequence is a valid phone number

---

## TODO
	•	Fix AmbiguityInterpreter to correctly handle:
	•	Block expansions like 69 → [69, 60 9]
	•	Merged blocks like 700 24 → 724
	•	Avoid over-generating invalid structures
