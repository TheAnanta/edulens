import Sidebar from "@/components/Sidebar";
import AvatarImage from "@/components/AvatarImage";
import AchievementCard from "./AchievementCard";
import RatingNews from "./RatingNews";
import Footer from "@/components/Footer";

export default function Page(props: { params: { id: string } }) {
  return (
    <div className="flex relative">
      <Sidebar />
      <div className="pt-24 px-16 w-full my-6">
        <div className="flex space-x-4">
          <div className="text-3xl font-semibold">
            Achievements
            <span className="font-semibold text-3xl uppercase">
              {props.params.id}
            </span>
          </div>
          <AvatarImage />
        </div>
        <div className="grid grid-cols-3 mt-12 gap-8 w-full">
          <div className="flex flex-col p-4 rounded-2xl bg-[var(--secondary-color)] h-fit">
            <div className="flex justify-between">
              <div className="flex flex-col">
                <p className="font-bold text-2xl mt-1">Chandra Sekhar Chopra</p>
                <p className="font-light text-lg mb-4">Alumni</p>
              </div>
              <span className="material-symbols-outlined">bookmark</span>
            </div>
            <img
              src={
                "https://www.euroschoolindia.com/wp-content/webp-express/webp-images/uploads/2023/08/impact-of-school-leadership.jpg.webp"
              }
              alt="Neeraj Chopra"
              className="w-full h-1/4 object-cover rounded-lg my-4"
            />
            <div>
              <p className="text-xl my-2 font-semibold">
                Google Summer Of Code 2024
              </p>
              <p className="text-lg">Web Development</p>
              <p>
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Eius
                rerum ad nemo odio corporis culpa a provident adipisci minima
                reprehenderit! Doloribus nobis aliquam voluptatem, quod placeat
                iure cumque quisquam alias!
              </p>
              <button className="bg-[var(--main-color)] text-white rounded-full px-4 py-2 w-full mt-4">
                View
              </button>
            </div>
            <div></div>
          </div>
          <div className="flex flex-col p-4 rounded-2xl bg-[var(--secondary-color)] h-fit">
            <div className="flex justify-between">
              <div className="flex flex-col">
                <p className="font-bold text-2xl mt-1">Manas Malla</p>
                <p className="font-light text-lg mb-4">Student</p>
              </div>
              <span className="material-symbols-outlined">bookmark</span>
            </div>
            <img
              src={
                "https://media.licdn.com/dms/image/v2/C5622AQG9NTn97HnbxA/feedshare-shrink_800/feedshare-shrink_800/0/1675272876380?e=2147483647&v=beta&t=6hfGXK3TBPOMBubPadasdNlLK3KKMx9WBGvbQ4cOBxQ"
              }
              alt="Neeraj Chopra"
              className="w-full h-72 object-cover rounded-lg my-4"
            />
            <div>
              <p className="text-xl my-2 font-semibold">
                Smart India Hackathon 2024
              </p>
              <p className="text-lg">Smart Automation</p>
              <div className="h-24"></div>
              <p>
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Eius
                rerum ad nemo odio corporis culpa a provident adipisci minima
                reprehenderit! Doloribus nobis aliquam voluptatem, quod placeat
                iure cumque quisquam alias!
              </p>

              <button className="bg-[var(--main-color)] text-white rounded-full px-4 py-2 w-full mt-4">
                View
              </button>
            </div>
          </div>
          <AchievementCard />
        </div>
        <h2 className="font-semibold my-12 text-3xl">
          Ratings and Latest News
        </h2>
        <div className="flex justify-between my-8 gap-6 ">
          <RatingNews />
          <div className="p-4 bg-[var(--secondary-color)] rounded-xl">
            <div className="flex justify-between mb-2">
              <h1 className="font-semibold">EduLens University</h1>
              <button className="bg-[var(--main-color)] text-white rounded-full px-4 py-2 mt-4">
                View
              </button>
            </div>
            <h3 className="my-2 text-xl">NIRF Ranking</h3>
            <p>
              Get to know NIRF ranking of our University, Lorem ipsum, dolor sit
              amet consectetur adipisicing elit.
            </p>
          </div>
        </div>
      </div>
    </div>
  );
}
