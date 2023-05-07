$(document).ready(function() {

  // Activate the Bootstrap tooltip plugin
  $('[data-toggle="tooltip"]').tooltip();

  // Activate the Bootstrap popover plugin
  $('[data-toggle="popover"]').popover();

  // Show a confirmation dialog when the user clicks the delete button
  $('.delete-entry').click(function(event) {
    event.preventDefault();
    var entryId = $(this).attr('data-entry-id');
    var entryTitle = $(this).attr('data-entry-title');
    if (confirm('Are you sure you want to delete "' + entryTitle + '"?')) {
      $.ajax({
        url: '/diary/entries/' + entryId,
        type: 'DELETE',
        success: function(result) {
          window.location.href = '/diary';
        },
        error: function(xhr, status, error) {
          alert('An error occurred while deleting the diary entry: ' + error);
        }
      });
    }
  });

  // Submit the search form when the user types something in the search box
  $('#search-input').on('input', function() {
    $('#search-form').submit();
  });

});
