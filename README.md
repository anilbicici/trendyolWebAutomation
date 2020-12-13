# Project Title

Trendyol Web Automation

## Before Starting

* Selenium and testNG are used for this project.

* Test is running on Chrome web browser by default. If you want to change browser (I assume that browser drivers are defined under C:\bin\ folder on your computer) you need to change browser paramater that located in testNG.xml file.

## Test Covarage

- www. The trendyol.com website opens.
- The opening of the home page is checked.
- The site is logged in.
- Login process is controlled.
- Enter the word "speaker" in the search box.
- According to the results, a random product is chosen from the displayed products.
- The selected product is added to card.
- The price on the product page is compared the price of the product on card. (Collate...with...)
- By increasing the piece, it is verified that the pieces of products are 2.
- The product is deleted from card and check that the basket is empty.

## How To Run Test

After cloning the project you need to run testNG.xml file.

## Structure

MAVEN - Project Structure. TESTNG - Unit test framework.

## Project Owner

Anıl Biçici

