import Sidebar from "@/components/Sidebar";
import PlacementCard from "./PlacementCard";
import Footer from "@/components/Footer";

const eventsData = [
    { eventName: "Amazon", location: "On Campus", placed: 26.2, avgLpa: 15.6 },
    { eventName: "Amazon", location: "On Campus", placed: 26.2, avgLpa: 15.6 },
    { eventName: "Amazon", location: "On Campus", placed: 26.2, avgLpa: 15.6 },
    { eventName: "Amazon", location: "On Campus", placed: 26.2, avgLpa: 15.6 },
    { eventName: "Amazon", location: "On Campus", placed: 26.2, avgLpa: 15.6 },
    { eventName: "Amazon", location: "On Campus", placed: 26.2, avgLpa: 15.6 },
    { eventName: "Amazon", location: "On Campus", placed: 26.2, avgLpa: 15.6 },
];

export default function Page(props: { params: { id: string } }) {
    return (
        <div className="flex relative">
            <Sidebar />
            <div className="pt-24 px-16 w-full my-6">

                <div>
                    <p className="w-full text-center text-4xl font-bold  ">Placements</p>
                </div>

                <div className="grid grid-cols-3 mt-12 gap-8 w-full mb-20">
                    {eventsData.map((event, index) => (
                        <PlacementCard
                            key={index}
                            eventName={event.eventName}
                            location={event.location}
                            placed={event.placed}
                            avgLpa={event.avgLpa}
                        />
                    ))}
                </div>

                <Footer />
            </div>
        </div>
    );
}