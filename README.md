# Decompose Dagger Sample

This is a sample Android project demonstrating the use of [Decompose](https://github.com/arkivanov/Decompose) library together with [Dagger](https://github.com/google/dagger) DI framework, [Anvil by Zac Sweers](https://github.com/ZacSweers/anvil/tree/main) and [anvil-utils](https://github.com/IlyaGulya/anvil-utils) (a tiny Anvil plugin for reducing Dagger boilerplate code even further).

## Project Structure

The project consists of the following modules:

- `repository` - Contains a simple in-memory `Repository`, shared in feature modules.
- `utils` - Contains some utils like `AppScope` annotation, etc.
- `feature-list` - Contains `ListComponent` that shows a list of text items. Clicking on an item opens `DetailsComponent`.
- `feature-details` - Contains `DetailsComponent` that shows the previously selected item. 
- `feature-root` - Contains `RootComponent` that navigates between `ListComponent` and `DetailsComponent`, plus some unit tests for `DefaultRootComponent`.
- `app-android` - Contains `MainActivity` that shows `RootComponent`.
