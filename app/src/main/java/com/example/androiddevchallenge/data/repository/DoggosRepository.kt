package com.example.androiddevchallenge.data.repository

import com.example.androiddevchallenge.data.model.Doggo
import com.example.androiddevchallenge.data.model.Image

object DoggosRepository {
    val doggosList = listOf<Doggo>(
        Doggo(
            id = "1",
            name = "Afador",
            breedGroup = "Mixed Breed Dogs",
            height = "20 to 29 Inches",
            age = "10",
            gender = Doggo.Gender.FEMALE,
            lifeSpan = "10 to 12 years",
            color = "Black",
            image = Image("https://static.wixstatic.com/media/ed79c0_311420e406ad46f88b93db288ae52e10~mv2.jpg/v1/fill/w_380,h_356,al_c,q_80,usm_0.66_1.00_0.01/afador_edited.webp", 380, 356),
            description = "The Afador is a mixed breed dog–a cross between the Afghan Hound and Labrador Retriever dog breeds. Loyal, energetic, and affectionate, these pups inherited some of the best qualities from both of their parents.\n"
        ),
        Doggo(
            id = "2",
            name = "Basset Hound",
            breedGroup = "Hound Dogs",
            height = "14 Inches",
            age = "5",
            gender = Doggo.Gender.MALE,
            lifeSpan = "10 to 12 years",
            color = "White, Brown",
            image = Image("https://cdn.wamiz.co.uk/media/cache/upload_16by9_1200/uploads/animal/breed/dog/adult/5ca61ebeb37c9443276800.jpg", 1200, 675),
            description = "The Basset Hound dog breed was bred for hunting small game such as rabbits and is still used for this purpose in some parts of the United States. When they’re not on the trail of a bunny, they’re laid-back family friends who love kids."
        ),
        Doggo(
            id = "3",
            name = "Catahoula Bulldog",
            breedGroup = "Mixed Bread Dog",
            height = "24 to 26 Inches",
            age = "6",
            gender = Doggo.Gender.MALE,
            lifeSpan = "10 to 14 years",
            color = "White",
            image = Image("https://www.europuppy.com/wp-content/uploads/american-bulldog.jpg", 640, 800),
            description = "The Catahoula Bulldog is a mixed breed dog–a cross between the Catahoula Leopard Dog and American Bulldog dog breeds. Agile, energetic, and loyal, these pups inherited some of the best qualities from both of their parents."
        ),
        Doggo(
            id = "4",
            name = "Dalmatian",
            breedGroup = "Companion Dogs",
            height = "19 to 24 Inches",
            age = "4",
            gender = Doggo.Gender.FEMALE,
            lifeSpan = "13 to 16 years",
            color = "White Black",
            image = Image("https://www.dogtime.com/assets/uploads/2011/01/file_23146_dalmatian-460x290.jpg",  460, 290),
            description = "Best known as the star of Disney’s 101 Dalmatians, this sleek and athletic Dalmatian dog breed has a history that goes back several hundred years. They started out as a coach dog but also served in many other capacities, including hunter, firehouse dog, and circus performer."
        ),
        Doggo(
            id = "5",
            name = "English Cocker Spaniel",
            breedGroup = "Sporting Dog",
            height = "1 Foot 3 Inches",
            age = "14",
            gender = Doggo.Gender.MALE,
            lifeSpan = "12 to 14 years",
            color = "Black White",
            image = Image("https://www.dogtime.com/assets/uploads/2011/01/file_22966_english-cocker-spaniel-460x290.jpg",  460, 290),
            description = "The English Cocker Spaniel is a medium-size dog breed with long ears and a happy disposition. The “Cocker” in their name comes from their days of hunting woodcock in England, although English Cockers have been used to hunt many other types of birds as well."
        ),
        Doggo(
            id = "6",
            name = "Finnish Spitz",
            breedGroup = "Sporting Dog",
            height = "15 to 20 Inches",
            age = "12",
            gender = Doggo.Gender.FEMALE,
            lifeSpan = "12 to 14 years",
            color = "Brown Black",
            image = Image("https://www.dogtime.com/assets/uploads/2011/01/file_23148_finnish-spitz-460x290.jpg",  460, 290),
            description = "The English Cocker Spaniel is a medium-size dog breed with long ears and a happy disposition. The “Cocker” in their name comes from their days of hunting woodcock in England, although English Cockers have been used to hunt many other types of birds as well."
        ),
        Doggo(
            id = "7",
            name = "German Pinscher",
            breedGroup = "Working Dog",
            height = "17 to 20 Inches",
            age = "7",
            gender = Doggo.Gender.MALE,
            lifeSpan = "12 to 14 years",
            color = " Golden White",
            image = Image("https://www.dogtime.com/assets/uploads/2011/01/file_22922_german-pinscher-460x290.jpg",  460, 290),
            description = "The German Pinscher dog breed is muscular and agile, powerful yet graceful. A medium-sized dog with an elegant appearance, they’re admired as much for their beauty as for their intelligence."
        ),
        Doggo(
            id = "8",
            name = "Azawakh",
            breedGroup = "Hound Dogs",
            height = "23 to 27 Inches",
            age = "6",
            gender = Doggo.Gender.MALE,
            lifeSpan = "12 to 15 years",
            color = "Black",
            image = Image("https://www.dogingtonpost.com/wp-content/uploads/2020/02/azawakh1-min-1000x600.jpg", 1000, 600),
            description = "A dog breed named for the Azawakh Valley in the Sahara desert where they originated, this is a lean and swift hunter with a regal presence. They’re proud but loyal and protective of their home and family."
        ),
        Doggo(
            id = "9",
            name = "Maltipoo",
            breedGroup = "Hybrid Dog",
            height = "8-14 Inches",
            age = "11",
            gender = Doggo.Gender.FEMALE,
            lifeSpan = "10 to 13 years",
            color = "Black White",
            image = Image("https://www.dogtime.com/assets/uploads/2011/01/file_23210_maltipoo-460x290.jpg",  460, 290),
            description = "Not actually a dog breed per se, the Maltipoo is a popular cross of the Maltese and Poodle, known for their fun-loving and affectionate nature. Active and charming, they’ll fit into all kinds of homes: apartment or house, family with kids or elderly single."
        ),
        Doggo(
            id = "10",
            name = "Irish Setter",
            breedGroup = "Sporting Dog",
            height = "2 Foot 3 Inches",
            age = "9",
            gender = Doggo.Gender.MALE,
            lifeSpan = "11 to 15 years",
            color = "Dark Brown",
            image = Image("https://s3.amazonaws.com/cdn-origin-etr.akc.org/wp-content/uploads/2017/11/22124201/Irish-Setter-puppy-laying-down.jpg", 729, 486),
            description = "Irish Setters originated as a gundogs in their native Ireland, and the dog breed‘s popularity soon spread, thanks to the beauty of their rich mahogany coat and their enthusiasm as bird dogs."
        )

    )
}