import requests
import sys
import json
import threading

TEAM_NAME = "The J Team"
TEAM_EMAIL = "hin.yip-2@student.manchester.ac.uk"

PROXY_URLS = [
    "http://pingproxies:scrapemequickly@194.87.135.1:9875", 
    "http://pingproxies:scrapemequickly@194.87.135.2:9875", 
    "http://pingproxies:scrapemequickly@194.87.135.3:9875", 
    "http://pingproxies:scrapemequickly@194.87.135.4:9875", 
    "http://pingproxies:scrapemequickly@194.87.135.5:9875"
]

proxies = {
    "http": PROXY_URLS[0], 
    "https": PROXY_URLS[0]
}


def create_team(team_name: str, team_email: str) -> str:
    r = requests.post(
        "https://api.scrapemequickly.com/register",
        data=json.dumps({"team_name": team_name, "team_email": team_email}),
        headers={"Content-Type": "application/json"}
    )

    if r.status_code != 200:
        print(r.json())
        print("Failed to create a team")
        sys.exit(1)

    return r.json()["data"]["team_id"]

def start_scraping_run(team_id: str) -> str:
    r = requests.post(f"https://api.scrapemequickly.com/scraping-run?team_id={team_id}", proxies=proxies)

    if r.status_code != 200:
        print(r.json())
        print("Failed to start scraping run")
        sys.exit(1)

    return r.json()["data"]["scraping_run_id"]

def submit(answers: dict, scraping_run_id: str) -> bool:
    r = requests.post(
        f"https://api.scrapemequickly.com/cars/solve?scraping_run_id={scraping_run_id}",
        data=json.dumps(answers),
        headers={"Content-Type": "application/json"}
    )

    if r.status_code != 200:
        print(r.json())
        print("Failed to submit answers")
        return False

    return True

if __name__ == "__main__":
    
    answers = {}

    # team_id = create_team(team_name=TEAM_NAME, team_email=TEAM_EMAIL)
    team_id = "a672a20f-1206-11f0-8f44-0242ac120003"

    scraping_run_id = start_scraping_run(team_id=team_id)

    # TODO: Update answers

    _ = submit(answers=answers, scraping_run_id=scraping_run_id)

    print(f"team_id: {team_id}; scrappimg_run_id: {scraping_run_id}")
    print(f"Programme ended ...")
