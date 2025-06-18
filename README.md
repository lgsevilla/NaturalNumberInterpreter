# NumberInterpreter

A simple Java console application built with Maven that interprets a sequence of digit blocks as potential Greek phone numbers. The app explores ambiguities inspired by Greek number pronunciation conventions — for example, the input 69 might represent 69 or 60 9. It validates each interpretation to determine whether it forms a valid 10- or 14-digit phone number.

---

## Features

- Accepts input as space-separated blocks of 1–3 digit numbers (e.g., `2 10 69 30 6 6 4`)
- Generates and outputs all valid and ambiguous interpretations of the number sequence
- Phone number validation:
  - ✅ 10-digit format (e.g., `2101234567` or `6912345678`)
  - ✅ 14-digit format starting with `00302` or `003069`
- Modular architecture:
  - `NumberInterpreter`: Entry point that handles user input and orchestrates output
  - `AmbiguityInterpreter`: Generates all plausible interpretations based on ambiguity rules
  - `BasePhoneValidator`: Confirms whether an interpretation is a valid phone number


