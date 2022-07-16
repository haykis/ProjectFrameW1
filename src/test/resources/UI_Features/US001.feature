Feature: US001
  Scenario:test01
    Given madunna ana sayfasina gider
    And ana sayfa giris ikonuna tiklar
    And Register butonuna tiklar
    And  SSN kutusuna uygun ssn girer
    Then hata nesajinin cikmadigini test eder
    And tarayiciyi kapatir

