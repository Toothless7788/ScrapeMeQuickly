import requests
import sys
import json

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


def request() -> str:
    r = requests.get(
        "https://scrapemequickly.com/all_cars?scraping_run_id=89d5dca4-0a34-11f0-b686-4a33b21d14f6",
        headers={"Content-Type": "application/json"}
    )

    if r.status_code != 200:
        print(r.json())
        print("Failed to create a team")
        sys.exit(1)

    return r.text

if __name__ == "__main__":
    
    answers = {}

    # team_id = create_team(team_name=TEAM_NAME, team_email=TEAM_EMAIL)
    team_id = "a672a20f-1206-11f0-8f44-0242ac120003"

    response = request()
    print(f"response: {response}")

    print(f"Programme ended ...")
