let cite = document.getElementById("citation-val");
// clear function
function clear() {
    authorname.value = "Author of Source";
    title.value = "Title of Source";
    websitename.value = "Website name";
    contributor.value = "Name of Contributor";
    contributor_role.value = "Role of Contributor";
    publisher_name.value = "Publisher Name";
    published_date.value = "Date Published";
    source_url.value = "Source URL";
}

// shows the generated citations.
function showCitations() {
    cite.innerHTML = citationA.concact_citation_info();
}

// sets up for button click
function buttonClick() {
    printCitation();
    showCitations();
}
