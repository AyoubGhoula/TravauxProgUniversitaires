from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys

from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
# Initialiser le pilote Chrome
browser = webdriver.Chrome()

# Accéder à Google
browser.get("https://www.google.com")

# Rechercher "isims"
search_box = browser.find_element(By.NAME, "q")
search_box.send_keys("isims")
search_box.send_keys(Keys.RETURN)

try:
    wait = WebDriverWait(browser, 10)
    link = wait.until(EC.presence_of_element_located((By.PARTIAL_LINK_TEXT, "Institut")))
    link.click()

    # Vérifier que le texte "En chiffre" est affiché
    text = browser.find_element(By.XPATH, "//*[contains(text(), 'En chiffre')]")
    assert "En chiffre" in text.text
    print("Assertion test passed")
except Exception as e:
    print("Assertion test failed:", e)

browser.quit()
print("Finished")
