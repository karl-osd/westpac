# Verify Kiwisaver Calculator Projected Balance

As a Product Owner
I want that the KiwiSaver Retirement Calculator users are able to calculate what their KiwiSaver
projected balance would be at retirement
So that
The users are able to plan their investments better.

## Acceptance Criteria
* Scenario 1 -
  User whose Current age is 30 is Employed @ a Salary 82000 p/a and contributes to
  KiwiSaver @ 4% has a PIR 17.5% and chooses a high risk profile is able to calculate his
  projected balances at retirement.
  
* Scenario 2 -
  User whose current aged 45 is Self-employed, has a PIR 10.5%, current KiwiSaver
  balance is $100000, voluntary contributes $90 fortnightly and chooses medium risk
  profile with saving goals requirement of $290000 is able to calculate his projected
  balances at retirement.
  
* Scenario 3 -
  User whose current aged 55 is not employed, has a PIR 10.5%, current KiwiSaver balance
  is $140000, voluntary contributes $10 annually and chooses medium risk profile with
  saving goals requirement of $200000 is able to calculate his projected balances at
  retirement.

### Setup

Setup the tests by going to the [KiwiSaver Calculator]( - "gotoCalculator()") page 

### [Scenario's] (- "Calculate KiwiSaver Retirement Projections" )

| [calculateGoalsRequirement][][Scenario](- "c:example") | [Age][age] | [Employment Status][employ] | [Annual Salary][salary] | [KiwiSaver Percent][percent] | [PIR][pir] | [KiwiSaver Balance][balance] | [Contribution][contri] | [frequency][freq] | [Risk Profile][profile] | [Savings Goal][goal] | [Expected Result][result] |
| ----- | ----- | -----         | ----- | ----- | ----- | -----  | ----- | -----       | -----  | -----  | -----   |
| 1     | 30    | Employed | 82000 | 4     | 17.5  | null      | null     | null        | High   | null      | 313,971 |
| 2     | 45    | Self-employed | null   | null     | 10.5  | 100000 | 90    | Fortnightly | Medium | 290000 | 230,481 |
| 3     | 55    | Not employed | null     | null     | 10.5  | 140000 | 10    | Annually    | Medium | 200000 | 176,557 |

[calculateGoalsRequirement]: - "#result = calculateGoalsRequirement(#age, #employ, #salary, #percent, #pir, #balance, #contri, #freq, #profile, #goal)"
[age]: - "#age"
[employ]: - "#employ"
[salary]: - "#salary"
[percent]: - "#percent"
[pir]: - "#pir"
[balance]: - "#balance"
[contri]: - "#contri"
[freq]: - "#freq"
[profile]: - "#profile"
[goal]: - "#goal"
[result]: - "?=#result"
