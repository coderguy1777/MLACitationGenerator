// ids for use in the program due to constant use.
let authorname = document.getElementById("author-val");
let title = document.getElementById("source-title");
let websitename = document.getElementById("website-title");
let contributor = document.getElementById("contrib-name");
let contributor_role = document.getElementById("contrib-role");
let publisher_name = document.getElementById("pub-name");
let published_date = document.getElementById("pub-date");
let source_url = document.getElementById("source-url");


// space and max len, along with the citation variable.
const space = "&nbsp";
const MAXCHARS = 87;
let citationA = new MLA(String(authorname.value), String(title.value), String(websitename.value), String(contributor.value), String(contributor_role.value), String(publisher_name.value), String(published_date.value), String(source_url.value));

function printCitation() {
    let x = citationA.concact_citation_info();
    let y = citationA.linebreak();
    console.log(x.toString());
}