# Cryptographic Frequency Analysis Tool

A Java-based tool that performs character frequency analysis on text files, particularly useful for analyzing substitution ciphers and cryptographic patterns.

## Overview

This program analyzes the frequency of alphabetic characters in a given text file, which is a fundamental technique in cryptanalysis. It's particularly useful for:
- Breaking simple substitution ciphers
- Analyzing text patterns
- Understanding character distribution in encrypted messages

## Features

- Reads text files and counts character frequencies
- Processes only alphabetic characters
- Sorts results by frequency in descending order
- Displays formatted frequency count for each character
- Supports custom input files via command line arguments

## Getting Started

### Prerequisites

- Java JDK 8 or higher
- A text file containing the cipher text to analyze

### Installation

1. Clone the repository:

bash
git clone https://github.com/FlabbHs/crypto-frequency-analysis.git

### Usage

1. Compile the Java file:

bash
javac FrequencyAnalysis.java

3. Run the program:

bash
Using default input file (ciphertext.txt)
java FrequencyAnalysis
Or specify a custom input file
java FrequencyAnalysis path/to/your/ciphertext.txt


### Example Output

Frequency Analysis
Character frequencies (most to least common):
n: 234
y: 187
v: 162
i: 155
x: 143
q: 132
h: 121
...


## How It Works

1. File Reading: Reads the input text file using BufferedReader
2. Character Processing: 
   - Converts text to character array
   - Filters for alphabetic characters only
3. Frequency Counting:
   - Uses HashMap to store character frequencies
   - Increments count for each character occurrence
4. Result Sorting:
   - Sorts characters by frequency in descending order
   - Displays formatted results

## Cryptanalysis Tips

For English text analysis, typical frequency order is:

E T A O I N S H R D L U


This can be used as a reference when analyzing potential substitution ciphers.

## Contributing

Contributions are welcome! Feel free to submit pull requests or open issues for improvements.

## Future Improvements

- [ ] Add percentage frequency calculation
- [ ] Include common English letter frequency comparison
- [ ] Add support for bigram/trigram analysis
- [ ] Implement basic cipher-breaking suggestions
- [ ] Add graphical visualization of frequencies
- [ ] Support for different character encodings

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Author

Sunny D.

## Acknowledgments

- Inspired by classical cryptanalysis techniques
- Based on frequency analysis principles used in cryptography
