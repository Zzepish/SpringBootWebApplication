1. @ResponseBody over controller actions tells Spring to to use Jasper (or any other template engine)
to work with the data, but to return data via Response to requestor.
2. @RestController - just virtually adds @ResponseBody to each route.
3. @PathVariable - annotation, for mapping variable from path, to argument variable.
4. @RequestMapping - allows to set specific base path for the controller (we can add
   multiple @RequestMapping annotation, but if we will add it to the controller, then the once
   are one methods - won't work, we will need to use @GetMapping, @PostMapping etc.)
5. @ModelAttribute is used for binding data from request param (in key value pairs),
but @RequestBody is used for binding data from whole body of the request like POST,PUT...
request types which contains other format like json, xml.
IMPORTANT NOTE: SEEMS LIKE @RequestBody waits for RAW json request, when for @ModelAttribute
we can just send normal form