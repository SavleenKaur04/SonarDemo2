import json
import requests
import os

# Load SonarCloud issues
with open("sonar_issues.json") as f:
    data = json.load(f)

# GitHub configuration
GITHUB_TOKEN = os.getenv("GITHUB_TOKEN")  # GitHub token for authentication
REPO = os.getenv("GITHUB_REPO")  # Format: "owner/repo"
PR_NUMBER = os.getenv("PR_NUMBER")  # PR number
PR_COMMIT_SHA = os.getenv("GITHUB_SHA")

print(GITHUB_TOKEN,REPO,PR_NUMBER,PR_COMMIT_SHA)

headers = {
    "Authorization": f"token {GITHUB_TOKEN}",
    "Accept": "application/vnd.github.v3+json"
}
print(headers)
# Check if there are any issues
if "issues" not in data or not data["issues"]:
    print("✅ No SonarCloud issues found.")
    exit(0)

# Extract and post issues as inline comments
for issue in data["issues"]:
    component = issue.get("component", "")
    file_path = component.split(":")[-1]  # Extract actual file path
    line = issue.get("textRange", {}).get("startLine")  # More accurate than `line`
    message = issue.get("message", "").strip()

    if not file_path or file_path == "null":
        print("❌ Skipping issue due to missing file path.")
        continue

    if not line or line == "null":
        print(f"❌ Skipping issue in {file_path} due to missing line number.")
        continue

    print(f"📌 Posting comment for {file_path} at line {line}: {message}")

    comment_body = {
        "body": f"🔍 **SonarCloud Issue:** {message}",
        "commit_id": PR_COMMIT_SHA,
        "path": file_path,
        "side": "RIGHT",
        "line": line
    }
    print(comment_body)
    comment_url = f"https://api.github.com/repos/{REPO}/pulls/{PR_NUMBER}/comments"
    print(comment_url)
    response = requests.post(comment_url, headers=headers, json=comment_body)
    print(response.json())

    if response.status_code == 201:
        print(f"✅ Comment posted on {file_path}:{line}")
    else:
        raise Exception(response);
