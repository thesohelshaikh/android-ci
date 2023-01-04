message "Thanks @#{github.pr_author} for contribution!"

# Make description compulsory
if github.pr_body.length <= 10
    fail "Please provide a summary in the Pull Request description."
end

# Make labels compulsory
if github.pr_labels.empty?
    warn "Please add labels to this PR."
end

# Check size of PR
if git.lines_of_code > 1000
    warn "Please consider breaking up this pull request."
end

# Code cleanup
if git.deletions > git.insertions
    message  "🎉 Code Cleanup!"
end

# Check if gradle of AndroidManifest is modified
def checkForFileAndroid(file)
  ext = File.extname(file)
  case ext
  # Warn when a file .gradle is modified
  when ".gradle"
    message("`#{file}` was modified")
  end
  # Warn when a FileManifest.xml is modified
  message("`#{file}` was modified") if file =~ /AndroidManifest\.xml/
end

def exceptionMessages(file)
  if File.file?(file)
    message "Something went wrong checking `#{file}`. Check your Dangerfile"
  else
    message "One of modified files could not be read, does it really exist?"
  end
end

#Check modified files, apply rules to them
git.modified_files.each do |file|
  begin
    checkForFileAndroid(file)
  rescue
    exceptionMessages(file)
  end
end

# Make it more obvious that a PR is a work in progress and shouldn't be merged yet
if github.pr_title.include? "[WIP]"
    warn("PR is classed as Work in Progress")
end

# Ensure a clean commits history
if git.commits.any? { |c| c.message =~ /^Merge branch '#{github.branch_for_base}'/ }
  warn "Please rebase to get rid of the merge commits in this PR"
end

# Warn when creating PRs for branches other than develop
if github.branch_for_base != "develop"
    warn "Please check correct base branch is selected. Current base branch is `#{github.branch_for_base}`."
end

# Make sure PRs have assignee
warn "This PR does not have any assignees yet." unless github.pr_json["assignee"]


android_lint.skip_gradle_task = true
android_lint.filtering = true
android_lint.report_file = "app/build/reports/lint-report.xml"
android_lint.lint