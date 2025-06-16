# NumberInterpreter

A simple Java console application using Maven that interprets a sequence of digit blocks as possible phone numbers. The app supports basic validation and explores ambiguity in number groupings (e.g. `69` could mean `69` or `60 9`).

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
