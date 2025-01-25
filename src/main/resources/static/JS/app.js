window.onload = function() {
    fetch('/api/posts')
        .then(response => response.json())
        .then(data => {
            const postsContainer = document.getElementById('posts-container');
            data.forEach(post => {
                const postElement = document.createElement('div');
                postElement.innerHTML = `<h2>${post.title}</h2><p>${post.content}</p>`;
                postsContainer.appendChild(postElement);
            });
        });
};
