# Galaxy Merchant Trading Guide

## Project Description

The **Galaxy Merchant Trading Guide** is an application designed to assist users in interpreting trade transactions within the fictional universe of Galaxy Merchant. The app allows users to convert various galactic terms into decimal numbers and calculate values in "Credits". Users can query the price of commodities, such as precious metals, using terminology consistent with the galaxy's trading traditions.

## Key Features

- **Numerical Interpretation**: Convert galactic terms into decimal numbers using Roman numeral rules.
- **Transaction Calculation**: Compute the value of commodities (e.g., Silver, Gold) in Credits based on the input query.
- **Flexible Query Processing**: Accepts complex queries related to commodity transactions and returns results in a user-friendly format.

## Prerequisites

To run this project, you'll need the following:

- Java 8 or higher
- Apache Maven 3.6.x or higher

## Installation and Setup

### 1. Clone the repository:

```bash
git clone https://github.com/yourusername/galaxy-merchant-trading-guide.git
cd galaxy-merchant-trading-guide
```

### 2. Build the project using Maven

```bash
mvn clean install
```

### 3. Run the application

```bash
mvn exec:java -Dexec.mainClass="com.galaxy.Main"
```

## Running Tests

```bash
mvn test
```

## Usage

- **Define an alien numeral**:

```bash
glob is I
```

- **Define an alien numeral**:

```bash
glob glob Silver is 34 Credits
```

- **Define an alien numeral**:

```bash
how much is pish tegj glob glob ?
```

- **Define an alien numeral**:

```bash
how many Credits is glob prok Silver ?
```

## Example

```
Input: glob is I
Input: glob glob Silver is 34 Credits
Input: how many Credits is glob glob Silver?
Output: glob glob Silver is 68 Credits
```
