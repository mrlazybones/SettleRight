# SettleRight

SettleRight compares expected payments with provider settlement records. It shows which rows match, which need attention, and why.

It does not move money, post to a ledger, or connect to a bank. The first version uses synthetic CSV files, one organization, and INR amounts with two decimal places.

## What it compares

An **expected payment** is what the business expected the provider to settle. A **settlement** is what the provider reported. The provider is the company that collected the customer's money, such as a payment gateway or a bank. Someone uploads that company's file. SettleRight does not call the provider.

Each settlement has three amounts:

- **Gross** is the amount before the provider's fee. This is compared to the expected payment.
- **Fee** is what the provider kept.
- **Net** is gross minus fee. It is stored and checked, and it is not used to decide a match.

Example: gross `1000.00`, fee `20.00`, net `980.00`. The expected payment matches only when its amount is `1000.00`.

Amounts with more than two decimal places are rejected. They are not rounded.

## Match rule

A row is **matched** only when all of these are true:

- The payment reference is the same.
- The currency is INR.
- The expected amount equals the settlement gross.
- Exactly one expected payment and one settlement share that reference.

Anything else stays unresolved:

| Situation | Result |
| --- | --- |
| Same reference and currency, amounts differ | Amount mismatch |
| No settlement, and the due date has passed | Missing settlement |
| No settlement, and the due date has not passed | Not yet due |
| Settlement reference has no expected payment | Unexpected settlement |
| More than one row shares the reference | Ambiguous; nothing is matched |

The due date is the payment date plus two weekdays. Saturday and Sunday are skipped. Public holidays are not. A run uses an explicit as-of date in Asia/Kolkata, so a payment is not called missing before its deadline.

Uploading the same file again must not create a second copy of those rows. Resolving an exception must not change the original amounts or mark an unmatched payment as matched.

## Sample files

`src/test/resources/samples/expected-payments.csv` and `src/test/resources/samples/settlements.csv` contain one row for each result above. The sample as-of date is 2026-09-24.

## Run locally

Requirements: Java 25, Git, and Docker Desktop when the database is added. Docker is not required to start the application today.

From the project directory:

```powershell
java -version
.\mvnw.cmd test
.\mvnw.cmd spring-boot:run
```

On macOS or Linux, use `./mvnw` instead of `.\mvnw.cmd`.

Then open http://localhost:8080. Stop the app with Ctrl+C.

`JAVA_HOME` must point at a JDK 25 installation. The Maven Wrapper downloads the Maven version pinned in `.mvn/wrapper/maven-wrapper.properties`. You do not need a separate Maven install.

## Current behavior

The application starts and listens on port 8080. There is no upload page, database, or reconciliation run yet. Opening `/` returns 404.
