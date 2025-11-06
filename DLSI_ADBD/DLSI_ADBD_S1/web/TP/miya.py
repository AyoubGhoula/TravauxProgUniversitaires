import tkinter as tk
from tkinter import messagebox
from git import Repo

# Path to your local git repo
REPO_PATH = '/path/to/your/repo'

def commit_changes():
    message = commit_entry.get()
    if not message.strip():
        messagebox.showerror("Error", "Commit message cannot be empty.")
        return
    try:
        repo = Repo(REPO_PATH)
        repo.git.add(all=True)
        repo.index.commit(message)
        messagebox.showinfo("Success", "Changes committed successfully.")
    except Exception as e:
        messagebox.showerror("Error", str(e))

def push_changes():
    try:
        repo = Repo(REPO_PATH)
        origin = repo.remote(name='origin')
        origin.push()
        messagebox.showinfo("Success", "Pushed to remote repository.")
    except Exception as e:
        messagebox.showerror("Error", str(e))

root = tk.Tk()
root.title("Git Commit & Push")

tk.Label(root, text="Commit message:").pack()
commit_entry = tk.Entry(root, width=50)
commit_entry.pack()

tk.Button(root, text="Commit", command=commit_changes).pack(pady=5)
tk.Button(root, text="Push", command=push_changes).pack(pady=5)

root.mainloop()
