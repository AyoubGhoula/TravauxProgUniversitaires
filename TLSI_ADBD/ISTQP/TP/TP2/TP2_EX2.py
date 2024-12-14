from selenium import webdriver
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.common.by import By
# Step 1) Open Firefox
browser = webdriver.Chrome()
# Step 2) Navigate to Facebook
browser.get("http://www.facebook.com")
# Step 3) Search & Enter the Email or Phone field & Enter Password
username = browser.find_element(By.ID,"email")
password = browser.find_element(By.ID,"pass")
submit = browser.find_element(By.NAME,"login")
username.send_keys("youremail")
password.send_keys("youroassword")
# Step 4) Click Login
submit.click()
wait = WebDriverWait(browser, 5)
try:
    title = browser.title
    assert 'Facebook' in title
    print('Assertion test pass')
except Exception as e:
    print('Assertion test failed', format(e))
browser.quit()
print("Finished")